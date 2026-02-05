#!/bin/bash
# Script to test authorization and error handling

BASE_URL="http://localhost:8080/api"

echo "=== Transaction History API - Test Authorization ==="
echo ""

# Test 1: Missing token
echo "1. Test missing authorization token:"
curl -s "$BASE_URL/transactions?pageSize=5" | json_pp
echo ""

# Test 2: Invalid token
echo "2. Test invalid authorization token:"
curl -s -H "Authorization: Bearer invalid_token_xyz" \
  "$BASE_URL/transactions?pageSize=5" | json_pp
echo ""

# Test 3: Invalid page size (too large)
echo "3. Test invalid page size (101):"
curl -s -H "Authorization: Bearer token_user1" \
  "$BASE_URL/transactions?pageSize=101" | json_pp
echo ""

# Test 4: Invalid page size (zero)
echo "4. Test invalid page size (0):"
curl -s -H "Authorization: Bearer token_user1" \
  "$BASE_URL/transactions?pageSize=0" | json_pp
echo ""

# Test 5: Invalid cursor
echo "5. Test invalid cursor:"
curl -s -H "Authorization: Bearer token_user1" \
  "$BASE_URL/transactions?cursor=INVALID_CURSOR&pageSize=5" | json_pp
echo ""

# Test 6: User trying to access another user's transaction
echo "6. User1 trying to access User2's transaction (TXN007):"
curl -s -H "Authorization: Bearer token_user1" \
  "$BASE_URL/transactions/TXN007" | json_pp
echo ""

# Test 7: Accessing deleted transaction
echo "7. Accessing deleted transaction (TXN003):"
curl -s -H "Authorization: Bearer token_user1" \
  "$BASE_URL/transactions/TXN003" | json_pp
echo ""

# Test 8: Admin accessing all users' transactions (should work)
echo "8. Admin accessing all users' transactions:"
curl -s -H "Authorization: Bearer token_admin" \
  "$BASE_URL/transactions?pageSize=15" | json_pp
echo ""

echo "Script completed!"
