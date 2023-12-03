1. create_library 
   1. Create Library
2. add_book
   1. Create Book
   2. Create Book Copies
      1. Validate If racks are available from rackservice
      2. Add BookCopy to rack
   3. Add BookCopy List to Book
3. remove_book_copy
   1. Search BookCopy
   2. Validate if BookCopy is not already Borrowd
   3. Delete Book Copy from List in Book
   4. Free the rack
   5. Delete from Book Copy
4. borrow_book
   1. Validate No of Books for User
   2. Search Book & Validate if Book Id is valid
   3. Validate If BookCopy is Available
   4. Create User
   5. Borrow Action
      1. Add to book Copy List of User
      2. Add due Date
      3. Vacate the Rack
         1. Remove from PQ
         2. Remove Rack from BookCopy
      4. Update Status of BookCopy
      5. Update Borrowing List
5. borrow_book_copy
   1. Validate No of Books for User
   2. Search BookCopy & Validate if BookCopy Id is valid
   3. Validate If BookCopy is Available
   4. Create User
   5. Borrow Action
      1. Add to book Copy List of User
      2. Add due Date
      3. Vacate the Rack
         1. Remove from PQ
         2. Remove Rack from BookCopy
      4. Update Status of BookCopy
      5. Update Borrowing List
6. return_book_copy
   1. Search BookCopy & Validate if BookCopy Id is valid
   2. Search Which User has that book copy
   3. Return Action
      1. Remove book Copy List of User
      2. Remove due Date
      3. Add to rack ( What if no rack is present )
      4. Update Status of BookCopy
      5. Update Borrowing List
7. print_borrowed
   1. Get all the books of User
8. search
   1. book_id
   2. author
   3. publisher

Book
< book_id : Book >

BookCopy
< book_copy_id : BookCopy >

User
< user_id : User >

Rack
PQ - < 1, 3, 5>