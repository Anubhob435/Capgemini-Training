#!/bin/bash
# Script to get paginated transactions with filters

BASE_URL="http://localhost:8080/api"
AUTH_TOKEN="token_user1"

echo "=== Transaction History API - Get Transactions ==="
echo ""

# Example 1: Get first page (default)
echo "1. Get first page (5 records):"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions?pageSize=5" | json_pp
echo ""

# Example 2: Get transactions with cursor
echo "2. Get next page with cursor (replace TXN005 with actual cursor):"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions?cursor=TXN005&pageSize=5" | json_pp
echo ""

# Example 3: Filter by account
echo "3. Filter by account (ACC001):"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions?accountId=ACC001&pageSize=10" | json_pp
echo ""

# Example 4: Filter by amount range
echo "4. Filter by amount range (\$50 - \$200):"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions?minAmount=50&maxAmount=200" | json_pp
echo ""

# Example 5: Filter by date range
echo "5. Filter by date range (last 7 days):"
START_DATE=$(date -u -d '7 days ago' +%Y-%m-%dT%H:%M:%S)
END_DATE=$(date -u +%Y-%m-%dT%H:%M:%S)
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions?startDate=$START_DATE&endDate=$END_DATE" | json_pp
echo ""

# Example 6: Combine multiple filters
echo "6. Combine filters (account + amount range):"
curl -s -H "Authorization: Bearer $AUTH_TOKEN" \
  "$BASE_URL/transactions?accountId=ACC001&minAmount=50&maxAmount=500&pageSize=10" | json_pp
echo ""

echo "Script completed!"
