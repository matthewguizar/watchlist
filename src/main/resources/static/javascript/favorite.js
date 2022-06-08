const cookieCArr = document.cookie.split("=");
const userId = cookieCArr[1];

const favContainer = document.getElementById("fav-container");
const favorites = document.getElementById("favorites");

    const headers = {
        'Content-Type': 'application/json'
    }
    const populateMovie = (obj) => {
        if (!obj){
            obj = {
                id: '',
                movieDto: '',
                user: '',
                watched: ''

            }
        }
    }


    const getAllLibraries = async () => {
        const response = await fetch (`http://localhost:8080/home`,{
            method: "GET",
            headers: headers
        })
            .catch(err => console.error(err.message));

        let responseArr = await response.json()
        console.log(responseArr);
        createLibraryCard(responseArr)
}

    const createLibraryCard = (arr) => {
        arr.forEach(obj => {
            let movieCard = document.createElement("div")
            movieCard.innerHTML = `<div class="card-groups" style="width: 18rem;">
    <img src="https://image.tmdb.org/t/p/original${obj.movieDto.posterPath} class="card-img-top">
    <div class="card-body">
        <p class="card-text" data-product="${obj.id}"> ${obj.movieDto.title}</p>
        <p>${obj.movieDto.overview}</p>
    </div>
    </div>`
            favContainer.append(movieCard)
        })
}

getAllLibraries()
