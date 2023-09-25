            # Bank Management System

Author Name : Md Afzal Ansari


This is my first java project, I will try my best to make it more beautiful and some new features,I added only some limited features :
Features of this project :

     # I will try to add Register and Login Frame and I work on its features like if you are a new user, just click "Register" button and fill the application form for opening account.

        # it will generate a random form number while filling Application form
        but form will be same for all the application form

        #it has three pages to fill the page
            page 1 : Customer Basic Details Like :
                        -> Name
                        -> Father Name
                        -> Date Of Birth
                        -> Gender
                        -> Email
                        -> Marital Status
                        -> State
                        -> District
                        -> Village/Area
                        -> Pin Code
            # in page 1 . It has 2 buttons : a. CLEAR & b. NEXT
            @if you press clear button : it will creal all the information you filled, except Gender and Marital Status, because the are set default.
            @if you press next button : You Will redirect to the next SignUp Page form with same form number :

            # In Page 2 : In this page Customer fill some additional information / details like :
                        -> Religious
                        -> Category
                        -> Annual Income
                        Educational Details like :
                        -> Qualification
                        -> Occupation
                        -> Aadhar Number (12 digit fixed and unique)
                        -> Pan Number (10 digit Fixed and unique)
                        -> Phone Number (10 digit fixed and unique)
                        -> Senior Citizen (yes or no (Checked Box))
            # In page 2 : it has 2 buttons : Back and Next
            @ Back Button : If you press back button you will redirect to the previous page(SignUp Page 1) 
            @ next Button : If you Press Next Button you will redirect to the next signUp page that is SignUp Page 3.

            # In page 3 : In this page we Customer will choose the account type, which type of account he/she want to open like :
                    -> Saving Account
                    -> Current Account
                    -> Fixed Deposit Account
                    -> Recurring Deposit Account
            
            @ In this page you got some additional information about how your card number looks like and whats the length of your card number and pin number and you will aware about our services like :
                    -> ATM Card
                    -> Cheque Book (Yet, not Implemented)
                    -> Mobile Banking (Yet, Not Implemented)
                    -> Email Alerts (Yet, Not Implemented)
                    -> Internet Banking (Yet, Not Implemented)
                    -> E-Statement
            # it has a checked description like :
                -> All the information entered by you is correct.
            
            # in signUppage3 you will get 3 buttons : Back, Cancle, and Submit
            Back : If you press back-> Redirect to the previous SignUp Form
            Cancle : If you click cancle-> You Will get a confirm Dialoge Box, 
                it will ask you : Are you sure you want to cancle and it will give you 2 options : YES OR NO
                    If you press yes : You will redirect to the main page and your form will get cancle.

                    If you press No : You will stay on same page(SignUpPage3)
                    If you press Submit : You Will redirect to the Final Application Form where you will see your all the information you fill till now.

        # in this final application form you have to check, is all the information above mantion is correct or note ?

         if yes you have to checked the confirm box and submit,
         if not then you have to go back using back button.

         If you click submit, you will get a "Thankyou" Message Box, and you will get your auto generated "Account Number", "Card Number", "Pin Number"
         -> all are unique;
         -> In account number : First 5 digits and form last 4 digits will same for all the accounts numbers like :
            First five Digits : 502000
            Last Four digits : 6500
            Pin Number Unique;
            First 4 digits of card number will remain same : 5883
            You will get an IFSC Code : OAS0001177

        If you are register for the first time you have to login first,
        Click the login button and you will redirect to the Login page where you have to use your card number and pin number for login;

        # I will try to handle Exceptions
        # I store all the information in SQL Database;
        # DataBase Schemas :
            -> SignUp Page 1 : Store all the SignUp Page 1 Details
            -> SignUp Page 2 : Store all the SignUp Page 2 Details
            -> SignUp Page 3 : Store all the SignUp Page 3 Details
            -> Login :       : Store Card Number and Pin Number
            -> Customer Details : Store "Card Number", "Account Number", "Pin Number", "Account Type", and "IFSC Code".

ATM Features :
        1. Deposit Section
        2. Mini Statement
        3. Change Pin
        4. Withdraw
        5. Check Balance
        6. Check Your Personal Details
        7. Fast Cash
        8. Exit : If you press it your program will exit.