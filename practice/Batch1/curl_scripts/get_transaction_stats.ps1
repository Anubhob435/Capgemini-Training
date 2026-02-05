# Script to get transaction statistics

$BASE_URL = "http://localhost:8080/api"

Write-Host "=== Transaction History API - Get Transaction Statistics ===" -ForegroundColor Green
Write-Host ""

# Example 1: Get stats for user1
Write-Host "1. Get statistics for user1:" -ForegroundColor Cyan
$headers1 = @{ "Authorization" = "Bearer token_user1" }
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/stats" -Headers $headers1 -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 2: Get stats for user2
Write-Host "2. Get statistics for user2:" -ForegroundColor Cyan
$headers2 = @{ "Authorization" = "Bearer token_user2" }
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/stats" -Headers $headers2 -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 3: Get stats for admin (all transactions)
Write-Host "3. Get statistics for admin (all transactions):" -ForegroundColor Cyan
$headersAdmin = @{ "Authorization" = "Bearer token_admin" }
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions/stats" -Headers $headersAdmin -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

Write-Host "Script completed!" -ForegroundColor Green
