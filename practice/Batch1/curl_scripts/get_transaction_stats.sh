#!/bin/bash
# Script to get transaction statistics

BASE_URL="http://localhost:8080/api"

echo "=== Transaction History API - Get Transaction Statistics ==="
echo ""

# Example 1: Get stats for user1
echo "1. Get statistics for user1:"
curl -s -H "Authorization: Bearer token_user1" \
  "$BASE_URL/transactions/stats" | json_pp
echo ""

# Example 2: Get stats for user2
echo "2. Get statistics for user2:"
curl -s -H "Authorization: Bearer token_user2" \
  "$BASE_URL/transactions/stats" | json_pp
echo ""

# Example 3: Get stats for admin (all transactions)
echo "3. Get statistics for admin (all transactions):"
curl -s -H "Authorization: Bearer token_admin" \
  "$BASE_URL/transactions/stats" | json_pp
echo ""

echo "Script completed!"
