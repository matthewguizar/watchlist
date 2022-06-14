const cookieCArr = document.cookie.split("=");
const userId = cookieCArr[1];

const favContainer = document.getElementById("fav-container");
const favorites = document.getElementById("favorites");

const url = "https://onmylist.herokuapp.com/"

    const headers = {
        'Content-Type': 'application/json'
    }
    const populateMovie = (obj) => {
        if (!obj){
            obj = {
                id: '',
                movie: {
                    id: '',
                    overview: '',
                    title: '',
                    posterPath: '',
                    backdropPath: '',
                    releaseDate: ''
                },
                watched: ''

            }
        }
    }


    const getLibrary = async (userId) => {
        const response = await fetch (`${url}home/${userId}`,{
            method: "GET",
            headers: headers
        })
            .catch(err => console.error(err.message));

        let responseArr = await response.json()
        console.log(responseArr);
        createLibraryCard(responseArr)
}

const deleteLibrary = async (libraryId) => {
   await fetch(`${url}home/${libraryId}`, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))
       location.reload()
    
}

    const createLibraryCard = (arr) => {
        arr.forEach(obj => {
            let movieCard = document.createElement("div")
            movieCard.innerHTML = `
    <div class="card-groups" style="width: 18rem;">
        <img src="https://image.tmdb.org/t/p/original${obj.movie.posterPath}" class="card-img-top">
        <div class="card-body">
            <p class="card-text" data-product="${obj.id}"> ${obj.movie.title}</p>
            <p>${obj.movie.overview}</p>
            <button class="btn btn-danger" onclick="deleteLibrary(${obj.id})">Delete</button>  
       </div>
       <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1"  value="${!obj.watched}">
            True
            </label>
       </div>
       <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2">
            <label class="form-check-label" for="flexRadioDefault2"  value="${obj.watched}">
            False
            </label>
       </div>
         
    </div>`
            favContainer.append(movieCard)
        })
}


getLibrary(userId);
