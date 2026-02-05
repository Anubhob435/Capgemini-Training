#!/bin/bash
# Script to get a specific transaction by ID

BASE_URL="http://localhost:8080/api"
AUTH_TOKEN="token_user1"

echo "=== Transaction History API - Get Transaction by ID ==="
echo ""

# Example 1: Get valid transaction
TRANSACTION_ID="TXN001"
echo "1. Get transaction $TRANSACTION_ID:"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions/$TRANSACTION_ID" | json_pp
echo ""

# Example 2: Try to get another user's transaction (should fail)
echo "2. Try to get another user's transaction (TXN007) - should fail:"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions/TXN007" | json_pp
echo ""

# Example 3: Try to get non-existent transaction
echo "3. Try to get non-existent transaction (TXN999) - should fail:"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions/TXN999" | json_pp
echo ""

# Example 4: Try to get deleted transaction (should fail)
echo "4. Try to get deleted transaction (TXN003) - should fail:"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions/TXN003" | json_pp
echo ""

echo "Script completed!"
