(ns entelechy.routes.home
  (:require [entelechy.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [clojure.java.io :as io]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [ring.util.response :refer [redirect]]
            [clojure.string :as st])
  (:use markdown.core))


(defn slurp-n-split [posts]
  (zipmap [:title :category :date :content] (st/split (slurp posts) #"卍")))

(defn get-post [post]
  (layout/render
   "post.html"
  {:post (slurp-n-split (io/file (str "posts/" (st/replace post " " "-") ".md")))}))



(defn get-all-posts []
  (map slurp-n-split (.listFiles (io/file "posts/"))))


;(defn validate-post [params]
 ; (first
  ; (b/validate
   ; params
    ;:name v/required
    ;:message [v/required [v/min-count 10]])))


(defn home-page [{:keys [flash]}]
  (layout/render
    "home.html"
   (merge {:posts (get-all-posts)}
          (select-keys flash [:name :message :errors]))))

(defn about-page []
  (layout/render "about.html"))


(defroutes home-routes
  (GET "/" request (home-page request))
  (GET "/posts/:id" [id] (get-post id))
  (GET "/about" [] (about-page)))
