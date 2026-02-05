# Script to get a specific transaction by ID

$BASE_URL = "http://localhost:8080/api"
$AUTH_TOKEN = "token_user1"

Write-Host "=== Transaction History API - Get Transaction by ID ===" -ForegroundColor Green
Write-Host ""

$headers = @{
    "Authorization" = "Bearer $AUTH_TOKEN"
}

# Example 1: Get valid transaction
$TRANSACTION_ID = "TXN001"
Write-Host "1. Get transaction $TRANSACTION_ID:" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/$TRANSACTION_ID" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 2: Try to get another user's transaction (should fail)
Write-Host "2. Try to get another user's transaction (TXN007) - should fail:" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/TXN007" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 3: Try to get non-existent transaction
Write-Host "3. Try to get non-existent transaction (TXN999) - should fail:" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/TXN999" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 4: Try to get deleted transaction (should fail)
Write-Host "4. Try to get deleted transaction (TXN003) - should fail:" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/TXN003" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

Write-Host "Script completed!" -ForegroundColor Green
