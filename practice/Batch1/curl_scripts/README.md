# Transaction History API - Helper Scripts

This folder contains helper scripts to test the Transaction History API endpoints.

## Available Scripts

### 1. get_transactions.sh / get_transactions.ps1
Get paginated list of transactions with optional filters.

### 2. get_transaction_by_id.sh / get_transaction_by_id.ps1
Get a specific transaction by its ID.

### 3. get_transaction_stats.sh / get_transaction_stats.ps1
Get transaction statistics for the authenticated user.

### 4. test_authorization.sh / test_authorization.ps1
Test authorization and error handling scenarios.

## Usage

### On Linux/Mac:
```bash
chmod +x *.sh
./get_transactions.sh
```

### On Windows PowerShell:
```powershell
.\get_transactions.ps1
```

## API Endpoints (If this were a real REST API)

- `GET /api/transactions` - Get paginated transactions
- `GET /api/transactions/:id` - Get transaction by ID
- `GET /api/transactions/stats` - Get transaction statistics

## Authentication

All endpoints require an `Authorization` header with a valid session token:
```
Authorization: Bearer <token>
```

Valid test tokens:
- `token_user1` - Regular user (user1)
- `token_user2` - Regular user (user2)
- `token_admin` - Admin user

## Query Parameters

### GET /api/transactions

- `cursor` - Cursor for pagination (optional)
- `pageSize` - Number of records per page (1-100, default: 10)
- `accountId` - Filter by account ID
- `startDate` - Filter by start date (ISO 8601 format)
- `endDate` - Filter by end date (ISO 8601 format)
- `minAmount` - Filter by minimum amount
- `maxAmount` - Filter by maximum amount

### Examples:

1. Get first page:
```bash
curl -H "Authorization: Bearer token_user1" \
  "http://localhost:8080/api/transactions?pageSize=5"
```

2. Get next page with cursor:
```bash
curl -H "Authorization: Bearer token_user1" \
  "http://localhost:8080/api/transactions?cursor=TXN005&pageSize=5"
```

3. Filter by account:
```bash
curl -H "Authorization: Bearer token_user1" \
  "http://localhost:8080/api/transactions?accountId=ACC001&pageSize=10"
```

4. Filter by amount range:
```bash
curl -H "Authorization: Bearer token_user1" \
  "http://localhost:8080/api/transactions?minAmount=50&maxAmount=200"
```

5. Filter by date range:
```bash
curl -H "Authorization: Bearer token_user1" \
  "http://localhost:8080/api/transactions?startDate=2026-01-01T00:00:00&endDate=2026-02-05T23:59:59"
```

## Note

Since this is a Java demonstration (not an actual REST API server), these scripts show what the curl commands would look like. To use them with a real REST API, you would need to:

1. Deploy the API to a web server (e.g., using Spring Boot)
2. Update the BASE_URL in the scripts to point to your server
3. Run the scripts against the live API
