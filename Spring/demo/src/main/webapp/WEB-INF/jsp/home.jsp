<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f5f7fb;
            color: #1f2937;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            padding: 24px;
        }

        .card {
            width: 100%;
            max-width: 560px;
            background: #ffffff;
            border: 1px solid #e5e7eb;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(31, 41, 55, 0.1);
            padding: 28px;
        }

        h1 {
            margin: 0 0 10px 0;
            font-size: 28px;
        }

        p {
            margin: 0 0 10px 0;
            color: #4b5563;
        }

        .badge {
            display: inline-block;
            margin-top: 8px;
            padding: 6px 10px;
            border-radius: 999px;
            background: #e0e7ff;
            color: #1f3fb3;
            font-weight: 600;
            font-size: 13px;
        }

        .actions {
            margin-top: 20px;
        }

        a {
            color: #2d6cdf;
            text-decoration: none;
            font-weight: 600;
        }

        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<main class="card">
    <h1>Home</h1>
    <p>You are logged in successfully.</p>
    <p class="badge">Logged in as: ${username}</p>

    <div class="actions">
        <a href="/login">Logout</a>
    </div>
</main>
</body>
</html>

