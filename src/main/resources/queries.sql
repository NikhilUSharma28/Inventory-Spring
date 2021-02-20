Insert_pro = INSERT INTO inventory (Product_Name, Product_rating) VALUES (?, ?);

Select_pro = select Product_Name, Product_rating from inventory where Product_Id =?

Select_all = select * from inventory

Delete_pro = delete from inventory where Product_Id = ?;

Update_pro = update inventory set Product_Name = ?,Product_rating= ? where Product_Id = ?;

Insert_user = INSERT INTO User (Firstname, lastname, email, pass) VALUES (?, ?, ?, ?);

Validate_User = select * from User where email=? and pass=?;

Select_all_jpa = Select inven from Inventory inven

login_jpa = select q from User q where q.email=:email and q.pass=:pass