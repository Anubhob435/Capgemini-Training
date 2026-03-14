<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="/css/register.css" />
</head>
<body>
    <main>
        <h2>Create your account</h2>
        <form action="/register" method="post">
            <div>
                <label for="username">Username</label>
                <input id="username" name="username" type="text" required />
            </div>
            <div>
                <label for="email">Email</label>
                <input id="email" name="email" type="email" required />
            </div>
            <div>
                <label for="password">Password</label>
                <input id="password" name="password" type="password" required />
            </div>
            <button type="submit">Register</button>
        </form>
    </main>
</body>
</html>
