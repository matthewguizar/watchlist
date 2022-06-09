const loginForm = document.getElementById("login-form");
const loginUsername = document.getElementById("login-username");
const loginPassword = document.getElementById("login-pwd");

const url = "http://localhost:8080/users"

const headers = {
    'Content-Type': 'application/json'
};


const handleSubmit = async (e) => {
    e.preventDefault();
    let bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    };

    const response = await fetch(`${url}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status == 200){
        document.cookie = `userId=${responseArr[1]}`
        window.location.replace(responseArr[0])

    }

}
loginForm.addEventListener("submit", handleSubmit)
