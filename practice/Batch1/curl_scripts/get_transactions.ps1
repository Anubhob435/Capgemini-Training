# Script to get paginated transactions with filters

$BASE_URL = "http://localhost:8080/api"
$AUTH_TOKEN = "token_user1"

Write-Host "=== Transaction History API - Get Transactions ===" -ForegroundColor Green
Write-Host ""

# Example 1: Get first page (default)
Write-Host "1. Get first page (5 records):" -ForegroundColor Cyan
$headers = @{
    "Authorization" = "Bearer $AUTH_TOKEN"
}
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?pageSize=5" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 2: Get transactions with cursor
Write-Host "2. Get next page with cursor (replace TXN005 with actual cursor):" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?cursor=TXN005&pageSize=5" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 3: Filter by account
Write-Host "3. Filter by account (ACC001):" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?accountId=ACC001&pageSize=10" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 4: Filter by amount range
Write-Host "4. Filter by amount range (`$50 - `$200):" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?minAmount=50&maxAmount=200" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 5: Filter by date range
Write-Host "5. Filter by date range (last 7 days):" -ForegroundColor Cyan
$startDate = (Get-Date).AddDays(-7).ToString("yyyy-MM-ddTHH:mm:ss")
$endDate = (Get-Date).ToString("yyyy-MM-ddTHH:mm:ss")
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?startDate=$startDate&endDate=$endDate" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

# Example 6: Combine multiple filters
Write-Host "6. Combine filters (account + amount range):" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$BASE_URL/transactions?accountId=ACC001&minAmount=50&maxAmount=500&pageSize=10" -Headers $headers -Method Get
    $response | ConvertTo-Json -Depth 10
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
}
Write-Host ""

Write-Host "Script completed!" -ForegroundColor Green
