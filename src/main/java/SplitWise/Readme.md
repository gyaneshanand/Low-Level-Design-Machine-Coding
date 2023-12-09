
Entites

1. User
   1. userId
   2. Map<user_id, UserLedger> owedByMap
2. UserLedger
   1. balance
   2. List<Transaction>
3. Transaction
   1. TransactionType
   2. Amount
   3. PaidUserId
   4. Map<user_id : Amount>
   5. SplitType
   6. name
   7. Notes
4. Group
   1. groupId
   2. List<User>