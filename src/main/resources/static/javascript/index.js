const url = "https://onmylist.herokuapp.com/"

const headers = {
    "Content-Type" : "application/json"
}

const indexPage = async () => {


    const response = await fetch (`${url}/register`, {

    })
    window.location = response;

    indexPage()
}