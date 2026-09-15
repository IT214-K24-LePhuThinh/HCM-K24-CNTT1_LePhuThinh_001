cách chạy hệ thống:
Chạy config-server trước sau đó eureka-server -> apigateway và chạy 2 cái product và category service

danh sách api
GET http://localhost:8080/api/categories/{id}  
GET http://localhost:8080/api/products
POST http://localhost:8080/api/products + Request Body
