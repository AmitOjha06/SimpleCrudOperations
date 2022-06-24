
# Simple Spring-Boot CRUD Operations 

A brief description of this is, it has 4 API's i.e Get, Post, Put
and Delete. These API's are perform basic operation on a user details stored in the list collection.


## API Reference

#### Get all data

```http
  GET /demo-crud/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `NA` | `NA` | **** |

#### Get data by id

```http
  GET /demo-crud/id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |

#### Add details


```http
  POST /demo-crud/add
```
It takes user details as body parameter.

User details:

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |
| `name`      | `string` | **Required**. Name of item to fetch |
| `designation`      | `string` | **Required**. Designation of item to fetch |
| `salary`      | `double` | **Required**. Salary of item to fetch |


#### Update details by id


```http
  PUT /demo-crud/update
```
For fetching details we take Id as a parameter.
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |

It takes user details which can be update as body parameter for updating the details.

User details:

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `designation`      | `string` | **Required**. Designation of item to fetch |
| `salary`      | `double` | **Required**. Salary of item to fetch |


#### Delete details by id


```http
  DELETE /demo-crud/delete
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |




## Contributing

Contributions are always welcome!

But this is a demo so it is making as own no Contributions is required.
