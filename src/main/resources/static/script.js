function login()
{
    const body = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    }
    request("/users/add", body);
    request("/users/get", body);
    request("/users/delete", body);
    //request("/email/send", body);

    document.getElementById("message").innerText = "Email sent";
    document.getElementById("login-form").hidden = true;
}

function request(endpoint, body)
{
    fetch("https://localhost:8080" + endpoint,
        {
            headers: {
                'Content-Type': 'application/json'
            },
            cors: "enable",
            method: "POST",
            body: JSON.stringify(body)
        }).then(res => res.json()).then(json => console.log(json));
}