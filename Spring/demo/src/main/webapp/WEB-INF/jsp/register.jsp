<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
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
            max-width: 460px;
            background: #ffffff;
            border: 1px solid #e5e7eb;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(31, 41, 55, 0.1);
            padding: 28px;
        }
        h2 { margin: 0 0 8px 0; font-size: 24px; }
        p.subtitle { margin: 0 0 20px 0; color: #6b7280; font-size: 14px; }
        .field { margin-bottom: 16px; }
        label { display: block; margin-bottom: 6px; font-weight: 600; font-size: 14px; }
        input { width: 100%; padding: 12px; border: 1px solid #e5e7eb; border-radius: 8px; font-size: 14px; }
        button { width: 100%; padding: 12px; margin-top: 12px; border: none; border-radius: 8px; background: #2d6cdf; color: #fff; font-size: 15px; font-weight: 600; cursor: pointer; }
        .message { margin-top: 12px; color: #15803d; font-size: 14px; }
        .back { display: inline-block; margin-top: 12px; font-size: 13px; color: #2d6cdf; text-decoration: none; }
    </style>
</head>
<body>
    <main class="card">
        <h2>Create your account</h2>
        <p class="subtitle">Register to continue</p>
        <form action="/register" method="post">
            <div class="field">
                <label for="username">Username</label>
                <input id="username" name="username" type="text" required />
            </div>
            <div class="field">
                <label for="email">Email</label>
                <input id="email" name="email" type="email" required />
            </div>
            <div class="field">
                <label for="password">Password</label>
                <input id="password" name="password" type="password" required />
            </div>
            <button type="submit">Register</button>
        </form>
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>
        <a class="back" href="/">Back to login</a>
    </main>
</body>
</html>