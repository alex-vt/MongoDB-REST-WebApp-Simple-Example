Project's [main page is here](../README.md).


## API Documentation for MongoDB-REST-WebApp-Simple-Example

The API methods operate with (receive and return) entries of several **object types**.


### How to use this API

You can use a REST client to test the API, for example, a third party app 
[https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo
](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo) 
for Chrome browser.

It's recommended to use JSON libraries for managing JSON objects in apps being developed.

On success, response status codes will be in range 200-299.


### Object types

There are the several types of entries used in data model,
they are received and returned by API methods as JSON objects.


#### User

The user account.

Here is the description of data fields of User:

| Field | Type | Description |
| ----- | ---- | ----------- |
| id | String | is unique |
| name | String | is unique |
| password | String | |

***Note.*** Order of fields is alphabetical for this and following JSON object types.

Example of a User object (JSON snippets are formatted for readability):

	{
		"id": "User_5273",
		"name": "Default Test User 1",
		"password": "password"
	}


#### Item

A simple data item

Description of data fields:

| Field | Type | Description |
| ----- | ---- | ----------- |
| id | String | is unique |
| name | String | is unique |

Example of an Event object:

    {
        "id": "Item_9241",
        "name": "Default Test Item 1"
    }


### API methods

API method URLs are composed from API server hostname and method paths.

For example, for hostname `http://dev.oleksiykovtun.com` and method path `/users/get/all` 
the full URL is `http://dev.oleksiykovtun.com/users/get/all`.

The list of API method paths:


#### /users/get/all

| HTTP Method | Produces (Content-Type header) | Description |
| ----------- | ------------------------------ | ----------- |
| GET | *JSON array* (`Content-Type: application/json;charset=utf-8`) | Returns all users in an array |

Example of response body:

    [
        {
            "id": "User_4362",
            "name": "Test User 1",
            "password": "password"
        },
        {
            "id": "User_8730",
            "name": "Test User 2",
            "password": "12345678"
        }
    ]

#### /users/get/{id}

| HTTP Method | Path parameter | Produces (Content-Type header) | Description |
| ----------- | -------------- | ------------------------------ | ----------- |
| GET | `{id}`: user ID | *JSON* (`Content-Type: application/json;charset=utf-8`) | Returns a user by ID |

Example of response body for request `/users/get/User_5273`:

	{
		"id": "User_5273",
		"name": "Test User 1",
		"password": "password"
	}

#### /users/add

| HTTP Method | Consumes (Content-Type header) | Produces (Content-Type header) | Description |
| ----------- | ------------------------------ | ------------------------------ | ----------- |
| PUT | *JSON* (`Content-Type: application/json;charset=utf-8`) | Text (`Content-Type: text/plain;charset=utf-8`) | Adds a new user and returns its ID |

Example of request body (`id` is not needed, ignored):

    {
        "name": "Test User 3",
        "password": "qwerty"
    }

#### /users/delete/{id}

| HTTP Method | Path parameter | Description |
| ----------- | -------------- | ----------- |
| DELETE | `{id}`: user ID | Removes a user by ID |

#### /items/get/all

| HTTP Method | Produces (Content-Type header) | Description |
| ----------- | ------------------------------ | ----------- |
| GET | *JSON array* (`Content-Type: application/json;charset=utf-8`) | Returns all items in an array |

Example of response body:

    [
        {
            "id": "Item_0527",
            "name": "Test Item 1"
        },
        {
            "id": "Item_1893",
            "name": "Test Item 2"
        }
    ]

#### /items/get/{id}

| HTTP Method | Path parameter | Produces (Content-Type header) | Description |
| ----------- | -------------- | ------------------------------ | ----------- |
| GET | `{id}`: item ID | *JSON* (`Content-Type: application/json;charset=utf-8`) | Returns an item by ID |

Example of response body for request `/items/get/Item_1893`:

    {
        "id": "Item_1893",
        "name": "Test Item 2"
    }

#### /items/add

| HTTP Method | Consumes (Content-Type header) | Produces (Content-Type header) | Description |
| ----------- | ------------------------------ | ------------------------------ | ----------- |
| PUT | *JSON* (`Content-Type: application/json;charset=utf-8`) | Text (`Content-Type: text/plain;charset=utf-8`) | Adds a new item and returns its ID |

Example of request body (`id` is not needed, ignored):

    {
        "name": "Test Item 3"
    }


#### /users/delete/{id}

| HTTP Method | Path parameter | Description |
| ----------- | -------------- | ----------- |
| DELETE | `{id}`: item ID | Removes an item by ID |
