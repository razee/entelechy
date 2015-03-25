--name: create-user!
-- creates a new user record
INSERT INTO users
(id, first_name, last_name, email, pass)
VALUES (:id, :first_name, :last_name, :email, :pass)

--name: update-user!
-- update an existing user record
UPDATE users
SET first_name = :first_name, last_name = :last_name, email = :email
WHERE id = :id

-- name: get-user
-- retrieve a user given the id.
SELECT * FROM users
WHERE id = :id


-- name: save-post!
-- creates a new post
INSERT INTO posts
(name, category, content)
VALUES (:name, :category, :content)

-- name: update-post!
-- updates an existing post
UPDATE posts
SET name = :name, category = :category, content = :content
WHERE id = :id
