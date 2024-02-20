var posts = [];
var string = "";
function getPosts() {
  console.log("calling api...");
  fetch("https://jsonplaceholder.typicode.com/posts")
    .then((res) => res.json())
    .then((data) => {
      Object.assign(posts, data);
      mapPostsToCard(posts);
    });
}
getPosts();
function mapPostsToCard(posts) {
  let i = 0;
  for (let i = 0; i < posts.length; i++) {
    // listString += "<li class='list-group-item'>" + names[i] + "</li>"
    string += `<div class="card mb-3" style="max-width: 700px;">
        <div class="row g-0 ">
          <div class="col-md-4">
            <img src="https://www.pngarts.com/files/5/User-Avatar-PNG-Transparent-Image.png" class="img-fluid rounded-start" alt="...">
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="card-title">${posts[i].title}</h5>
              <p class="card-text">${posts[i].body}</p>
              <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
            </div>
          </div>
        </div>
      </div>`;
  }

  document.getElementById("cardItem").innerHTML = string;
}
