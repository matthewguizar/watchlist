const registerForm = document.getElementById("form");
const registerUsername = document.getElementById("username");
const registerPass = document.getElementById("pwd");

const url = "https://onmylist.herokuapp.com/"
const headers = {
    "Content-Type" : "application/json"
}

const handleRegister = async (e) => {
    e.preventDefault();
    let bodyObj = {
        username: registerUsername.value,
        password: registerPass.value
    };

        if (registerUsername.value == "" && registerPass.value == ""){
            alert("Username and password required")
            return false
        }
        if (registerUsername.value == "") {
            alert("User name is required")
            return false
        }
        if (registerPass.value == ""){
            alert("Password is required")
            return false
    } else {
            const response = await fetch(`${url}users/register`, {
                method: "POST",
                body: JSON.stringify(bodyObj),
                headers: headers
            })
                .catch(err => console.error(err.message));

            const responseArr = await response.json();

            if (response.status === 200) {
                window.location.replace(responseArr[0])
            }
            if (response.status === 400) {
                window.alert("Username already exists, please try again")
            }

        }
};
registerForm.addEventListener("submit", handleRegister);