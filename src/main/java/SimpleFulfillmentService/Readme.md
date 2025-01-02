# Entities

1. Inventory ( There can be more than one inventory in the system.)
2. Product

# Associations

1 Inventory can have multiple products

# Operations

1. addInventory(productId, amount)
2. removeInventory(productId)
3. viewInventory()

# Points to note 

addInventory and removeInventory should take care of concurrency in multithreaded environment 
or in case of multiple concurrent requests