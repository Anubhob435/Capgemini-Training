<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        :root {
            --bg: #f5f7fb;
            --card: #ffffff;
            --primary: #2d6cdf;
            --primary-dark: #1f54b3;
            --text: #1f2937;
            --muted: #6b7280;
            --border: #e5e7eb;
            --error: #b91c1c;
            --error-bg: #fee2e2;
        }

        * { box-sizing: border-box; }

        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: var(--bg);
            color: var(--text);
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            padding: 24px;
        }

        .card {
            width: 100%;
            max-width: 420px;
            background: var(--card);
            border: 1px solid var(--border);
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(31, 41, 55, 0.1);
            padding: 28px;
        }

        h2 {
            margin: 0 0 8px 0;
            font-size: 24px;
        }

        p.subtitle {
            margin: 0 0 12px 0;
            color: var(--muted);
            font-size: 14px;
        }

        .hint {
            margin: 0 0 20px 0;
            color: var(--muted);
            font-size: 13px;
        }

        .field {
            margin-bottom: 16px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
            font-size: 14px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid var(--border);
            border-radius: 8px;
            font-size: 14px;
            transition: border-color 0.15s ease, box-shadow 0.15s ease;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: var(--primary);
            box-shadow: 0 0 0 3px rgba(45, 108, 223, 0.15);
        }

        .error {
            margin-top: 8px;
            padding: 10px 12px;
            border-radius: 8px;
            background: var(--error-bg);
            color: var(--error);
            font-size: 13px;
        }

        .actions {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-top: 4px;
        }

        a.link {
            font-size: 13px;
            color: var(--primary);
            text-decoration: none;
        }

        a.link:hover { text-decoration: underline; }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 12px;
            border: none;
            border-radius: 8px;
            background: var(--primary);
            color: #fff;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
        }

        button:hover { background: var(--primary-dark); }
    </style>
</head>
<body>
<main class="card">
    <h2>Welcome back</h2>
    <p class="subtitle">Sign in to continue</p>
    <p class="hint">Use default credentials: <strong>admin</strong> / <strong>admin</strong></p>

    <form action="/login" method="post">
        <div class="field">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="${username}" autocomplete="username" required>
        </div>
        <div class="field">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" autocomplete="current-password" required>
        </div>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <div class="actions">
            <a class="link" href="/forget-password">Forgot password?</a>
            <a class="link" href="/register">Create an account</a>
        </div>

        <button type="submit">Login</button>
    </form>
</main>
</body>
</html>

