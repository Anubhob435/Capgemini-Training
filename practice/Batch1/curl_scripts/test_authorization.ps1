# Script to test authorization and error handling

$BASE_URL = "http://localhost:8080/api"

Write-Host "=== Transaction History API - Test Authorization ===" -ForegroundColor Green
Write-Host ""

# Test 1: Missing token
Write-Host "1. Test missing authorization token:" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?pageSize=5" -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Test 2: Invalid token
Write-Host "2. Test invalid authorization token:" -ForegroundColor Cyan
$invalidHeaders = @{ "Authorization" = "Bearer invalid_token_xyz" }
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?pageSize=5" -Headers $invalidHeaders -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Test 3: Invalid page size (too large)
Write-Host "3. Test invalid page size (101):" -ForegroundColor Cyan
$validHeaders = @{ "Authorization" = "Bearer token_user1" }
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?pageSize=101" -Headers $validHeaders -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Test 4: Invalid page size (zero)
Write-Host "4. Test invalid page size (0):" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?pageSize=0" -Headers $validHeaders -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Test 5: Invalid cursor
Write-Host "5. Test invalid cursor:" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?cursor=INVALID_CURSOR&pageSize=5" -Headers $validHeaders -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Test 6: User trying to access another user's transaction
Write-Host "6. User1 trying to access User2's transaction (TXN007):" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/TXN007" -Headers $validHeaders -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Test 7: Accessing deleted transaction
Write-Host "7. Accessing deleted transaction (TXN003):" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/TXN003" -Headers $validHeaders -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Test 8: Admin accessing all users' transactions (should work)
Write-Host "8. Admin accessing all users' transactions:" -ForegroundColor Cyan
$adminHeaders = @{ "Authorization" = "Bearer token_admin" }
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?pageSize=15" -Headers $adminHeaders -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

Write-Host "Script completed!" -ForegroundColor Green
