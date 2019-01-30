
# PROJECT REQUIREMENTS

-   The system must have three views:
    -   Showing the total expenses for each month
    -   Showing the total expenses grouped by category
    -   Showing where the money comes from grouped by source
-   Choose one of the following to implement:
    -   Add the possibility to edit and persist the data
    -   Make the three visualizations as a single screen/page application, changing data smoothly. 

## Design choices
### Data
The data acquired from the provided server have been encapsulated in one single class, which we will reffer as **Expense**. As the data comes in JSON form it's easy to parse it to object fields and then to the database as long as we use compatible names for the fields.
The data used is that found in the `d4d8a7f0-d4be-4397-b950-f0c991438111` set of the **Dados Recife API**, found at http://dados.recife.pe.gov.br/dataset/despesas-orcamentarias. Notice that the number of elements in this database is 94178.

Besides the Expense class other three classes were created:
- **CategoryExpense**
	- Encapsulates total expenses by category.
- **MonthExpense** 
	- Encapsulates total expenses by month.
- **SourceExpense**
	- Encapsulates total expenses by source.

Instead of querying and grouping the Expense data when needed for the views we use these classes to store the totals. This way we update the database every time an Expense is added, removed or edited, notice that doing this we decreases the number of accesses to the database when we need to accesses the totals, as long as the requests for totals are greated than the Expense edits number. We no longer need to select all the data and group it when totals are requested.

### Back-end
With the data defined the implementation of the back-end with Spring Boot took into account the interaction between the classes. Notice that the uses should be able the edit only Expenses, but when an Expense is edited the values should be reflected into the other classes, adding or substracting values in the correct category, month or source.

When the server is started it starts to download data from the source, that is done in a separeted thread so we don't have to wait for all the data to be downloaded, it's possible to define how many elements will be downloaded and the size of the elements list, see more at [Expenses Application](#ExpensesApplication.java) section.

### Front-end
As there aren't much for the user to do a single page should sufficient for the interaction, all data can be viewed in the same page. In order to conceive a comprehensive only a view should be visible at a time, so components were used to display only the selected data.
Data were displayed in two forms, a table with all the classes fields and values and a graph.

# FRAMEWORK REQUIREMENTS

## Requeriments for the front-end
Node.JS (10.13.0):
https://nodejs.org/en/

(Remember to setup path variables)

With Node.JS installed, install Angular CLI (7.2.3):
`npm install -g @angular/cli`

You can check installations by using:
`node -v`
`npm -v`
`ng version`
### Requeriments for Chats.js:
Chart.js must be included in order to be able to present some graphs.
`npm install chart.js --save`
## Requeriments for back-end
Java 8:
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Spring Boot (2.0.4):
For this project we used Spring Tools 4 for Eclipse (there are other options):
https://spring.io/tools

# RUNNING THE APPLICATION
Using the downloaded Spring Boot tool run the `ExpensesApplication` class to run the back-end server. It can be accessed at http://localhost:8080.
A console for the database is available at http://localhost:8080/h2-console, with username: `sa` and empty password.
For the front-end navegate to the expenses-app folder (`~\Expenses\expense-app`) and execute the command `ng serve`.

# IMPORTANT FILES 

## Resource Files

Every data class have a associated resource class, located at `~\Expenses\src\main\java\com\felipehogrefe\expenses\resources`, they are:

- ExpenseResource.java
- CategoryExpenseResource.java
- MonthExpenseResource.java
- SourceExpenseResource.java 

Those files represents the API which can be accessed whem the server ir running, in each of those we have methods that returns the required data.

## Service Files
Like resources, every data class have a associated service class located at `~\Expenses\src\main\java\com\felipehogrefe\expenses\services`, they are:
- ExpenseService.java
- CategoryExpenseService.java
- MonthExpenseService.java
- SourceExpenseService.java 

The service classes do all the interaction with the database using corresponding repositories, they serve the resource classes doing the working needed to edit the data, for example, when an expense is edited the ExpenseService will edit categories, months and sources related to that expense.

## ExpensesApplication.java
The application file, located at `~\Expenses\src\main\java\com\felipehogrefe\expenses\domain` is used to start the serve. We have three fields:

- `querySize`
	- Defines how many elements are download each time from the source.
- `limit`
	- Defines how many elements are download in total from the source.

ExpensesApplication calls ExpenseGetter in a thread, this way its possible to initiate the server even without all the data downloaded, so the data in the fron-end may change as it is downloaded in the back-end.

As the number of elements in the database is 94178, it's recomended to don't set `limit` higher than that.

## ExpenseGetter.java and UrlToExpensesParser.java
ExpenseGetter is the class used the download elements from the source, its simply a loop from `0` to `limit` with increasing pace of `querySize` that accesses the source via URL. When the data is downloaded and parsed its saved into the database and category, month and source tables are updated.

UrlToExpensesParser gets the data downloaded on each pace of the ExpenseGetter loop and maps the JSON to Expense, notice that in order to make the mapping simple we needed to use non-standard names for the Expense class, such as `setUnidade_nome` instead of `setUnidadeNome`.