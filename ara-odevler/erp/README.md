# week-8-hw: ERP Project

This is an ERP(Enterprise Resource Planning) program which designed for logistics and financial systems of businesses. The project focuses on handling orders, products, customers, and bill(invoices).

## Features
- Order Management: Create, update, and delete orders. Each order can have multiple products and is associated with a customer.
- Product Management: Manage product information, including name, price, and stock quantity.
- Customer Management: Maintain customer records, including name, contact information, and address.
- Bill(Invoice) Generation: Automatically generate invoices for each order with detailed information about the products purchased and the total amount due with "KDV" taxations.
- Inventory Management: Keep track of product stock levels.

## Project Structure

- entity: BaseEntity(Generic entity class) and sub-entities; BillEntity, CustomerEntity, KdvEntity, OrderEntity, ProductEntity, StockEntity
- repository: BaseEntityRepository(Generic repository class) and sub-repositories; BillEntityRepository, CustomerEntityRepository, KdvEntityRepository, OrderEntityRepository, ProductEntityRepository, StockEntityRepository
- controller: BaseEntityController(Generic controller class) and sub-repositories; BillEntityController, CustomerEntityController, KdvEntityController, OrderEntityController, ProductEntityController, StockEntityController
- service: BaseEntityService(Generic abstract service class) and sub-repositories; BillEntityService, CustomerEntityService, KdvEntityService, OrderEntityService, ProductEntityService, StockEntityService