<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
    body {
        margin: 0;
        font-family: "Segoe UI", Arial, sans-serif;
        background: #f8fafc;
        color: #0f172a;
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
    } 
    .card {
        background: #fff;
        border: 1px solid #e2e8f0;
        border-radius: 12px;
        padding: 32px;
        box-shadow: 0 10px 30px rgba(15, 23, 42, 0.08);
        max-width: 520px;
        width: 100%;
        text-align: center;
    }
    h1 {
        margin: 0 0 12px 0;
        font-size: 28px;6
    }
    p { margin: 0 0 16px 0; color: #475569; }
    a.button {
        display: inline-block;
        padding: 12px 20px;
        border-radius: 8px;
        background: #2563eb;
        color: #fff;
        text-decoration: none;
        font-weight: 600;
        transition: background 0.15s ease, transform 0.1s ease;
    }
    a.button:hover { background: #1d4ed8; }
    a.button:active { transform: translateY(1px); }
</style>
</head>
<body>
    <main class="card">
        <h1>Welcome home</h1>
        <p>You are logged in. Customize this page with your app content.</p>
        <a class="button" href="index.html">Log out</a>
    </main>
</body>
</html>


