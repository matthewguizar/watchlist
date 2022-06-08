const cookieCArr = document.cookie.split("=");
const userId = cookieCArr[1];

const cardContainer = document.getElementById("cardContainer");



    const headers = {
        'Content-Type': 'application/json'
    }

    const populateMovie = (obj) => {
        if (!obj){
            obj = {
                id: '',
                overview: '',
                posterPath: '',
                releaseDate: '',
                title: '',
             backdropPath: ''

            }
        }
    }



    const getTopRated = async () =>{
        const response = await fetch(`http://localhost:8080/home/movies`, {
        method: "GET",
        headers: headers
    })
        .catch(err => console.error(err.message))

        let responseArr = await response.json();
        console.log("User Id: " + userId)
        createMovieCards(responseArr);

    }


    function createMovieCards(arr) {
        arr.forEach(obj => {
            let noteCard = document.createElement("div")
            noteCard.innerHTML = `<div class="card-groups" > Top 20 Rated Movies
    <div class="card w-25 h-50">
        <img class="card-img-top" src="https://image.tmdb.org/t/p/original${obj.posterPath}" alt="Card image cap">
        <div class="card-body">
        <h5 class="card-title" data-product="${obj.id}">${obj.title}</h5>
        <p class="card-text">${obj.overview}</p>
        <button class="btn btn-primary"onclick=" addMovie(${obj.id})">Add Movie</button>
        </div>
        <div class="card-footer">
         <small class="text-muted">${obj.releaseDate}</small>
        </div>
    </div> `
        cardContainer.append(noteCard);
        })
    }


const addMovie = async (movieId) => {
        const id = await addLibrary();
    const response = await fetch(`http://localhost:8080/home/${id}/${movieId}`, {
        method: "POST",
        headers: headers

    })
        .catch(err => console.error(err.message))

}


const handleLogout = () => {
    let c = document.cookie.split(';')
    for (let i in c) {
        document.cookie = /^[^=]+/.exec(c[i])[0] + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }

}

const addLibrary = async () => {
    const response = await fetch(`http://localhost:8080/home/${userId}`, {
        method: "POST",
        headers: headers
    })
        .catch(err => console.error(err.message))
    let library = await response.json();
    return library

}
getTopRated();



