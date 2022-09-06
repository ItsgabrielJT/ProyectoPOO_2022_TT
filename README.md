#  POO Final Project: Pharmacy System 🥵
### Members: 
- Joel Tates
- Omar Toro
## [Video explanation use](https://www.youtube.com/watch?v=q67DFqGd8Bs&t=29s) 
## [Video technical use](https://www.youtube.com/watch?v=EUx_xYeFQpQ)

## **Project description✍📔:**
The system consists of four types of classes from which all others are derived::

1. **Producto**
2. **Usuario**
3. **Cliente**
4. **Stock**

These classes work with the class ProcesarData<T>.

The system roles are:

1. **ADMINISTRATOR** 👨‍💼
2. **WINEMAKER** 👩‍🔧
3. **CASHIER** 💵
   
**Each role has actions to perform**

**CASHIER:**
    He can sale to costumers and execute the transaction, with each transaction must generate a sale note. Also, he can search the products available.

**WINEMAKER:**
    He can register, look, modify and delete available products from stock.

**ADMINISTRATOR:**
    He can access the functionality of grocer and cashier. Also, he can add, update and delete users. 


# Functionality

### **Login Window:** Login to access the main menu. 

[![login.png](https://i.postimg.cc/pd6BbQYX/login.png)](https://postimg.cc/4Kpcp9Sr)

---
---

# **EXPLANATION OF EACH ROLE**

## **ADMINISTRATOR** 🎫

[![Screenshot-2022-09-06-010939.png](https://i.postimg.cc/3wBPgqTf/Screenshot-2022-09-06-010939.png)](https://postimg.cc/Jys68Ptj)

> Can access all modules `Cashier`, `Winemaker` and `Users`

### **ACTIONS FOR ADMINISTRATOR ROLE**

### Some windows for administrator role.


[![Screenshot-2022-09-06-011152.png](https://i.postimg.cc/50Zd0C1f/Screenshot-2022-09-06-011152.png)](https://postimg.cc/LYB0QhnW)

> For **update** and **delete** options you must first enter the product code and **search** then will can update or delete.

***
***

## **CASHIER**


> Can access modules `Sales` and `Inventory`

### **ACTIONS FOR CASHIER ROLE**

**SELLER :** SELLING PRODUCTS**

[![Screenshot-2022-09-06-011536.png](https://i.postimg.cc/05F2MzZM/Screenshot-2022-09-06-011536.png)](https://postimg.cc/kDNdLX0q)
> Add products to the sale. 💵

**CLIENTS :** CUSTOMER NOT YET REGISTERED**

[![Screenshot-2022-09-06-011615.png](https://i.postimg.cc/y8PDZVkM/Screenshot-2022-09-06-011615.png)](https://postimg.cc/211jpNdG)
> You can **register customer** in this moment for the sale note and generate PDF.

***
***

## **GROCER**

> Can access modules `Stock`

1. Only can access to `Products` module.


### **Actions permited:** Total CRUD of `Products`. 📦

[![Screenshot-2022-09-06-011743.png](https://i.postimg.cc/Y9BTBwxS/Screenshot-2022-09-06-011743.png)](https://postimg.cc/1gMvD22x)

> For **update** and **delete** options you must first enter the product code and **search** then will can update or delete.

***
***

## **SALE NOTE** 📄
![Window Login](./assets_github/PDF.png)
***

## TYPE OF ERRORS 💀:

5. **If you send an incorrect email.**

![Window Login](./assets_github/email.png)

2. **There is no record to reference (FK) 🗝**

![Window Login](./assets_github/1452.png)

3. **The field exceeds the limit.**

![Window Login](./assets_github/1406.png)

4. **If you want to send an empty file.**

![Window Login](./assets_github/empety.png)


6. **If you puth a invalid path to save the note sell**

![Error path](./assets_github/invalid_path.PNG)


7. **If you send an incorrect phone.**

![Window Login](./assets_github/phone.png)


8. **If you send an empty file to DNI.**

![Window Login](./assets_github/dni.png)


***
***

## **CONFIGURATION FOR DATABASE!** 🎲

To set up your database it is important to have mysql **previously installed** on the computer where the .exe or .jar file will be run. ALso, you must **run the farmaciatyt.sql file in mySQL workbench**.

**Server remote next...**

### **Dates for run SQL**

The program already has a class that is in charge of **connecting to the database** with the appropriate user and password


### **Some recomendations for SQL**

Try to be guided by the schema diagram so that you can edit or add new tables.

[![Untitled-picture.png](https://i.postimg.cc/44Hn1D8S/Untitled-picture.png)](https://postimg.cc/SjqySvb6)

## **CONFIGURATION FOR EXECUTABLES!** 📂 

**[+]** Download the **Pharmacy-CRUD** folder, then go to C drive and put it in the **Program Files** folder.
This is because you need the icons to run the .exe and .jar files and so on to avoid path issues.