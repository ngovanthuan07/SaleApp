
function addComment(productId) {
    fetch("/SaleApplication/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "productId": productId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res);

        return res.json();

    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("commentArea");

        area.innerHTML = `
            <div class="row">
                <div class="col-md-2" style="padding: 10px">
                    <img class="rounded-circle" src="https://res.cloudinary.com/lap-trinh-java/image/upload/v1649398048/sekph45ob716ed2w6bds.jpg" style="width: 100px"/>
                </div>
                <div class="col-md-10 my-date">
                    <p>${data.content}</p>
                    <i>${moment(data.createdDate).fromNow()}</i>
                </div> 
            </div> 
        ` + area.innerHTML;
    });
}

function addToCart(id, name, price) {
    event.preventDefault();
    fetch("/SaleApplication/api/cart", {
        method: 'post',
        body: JSON.stringify( {
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)

        return res.json()

    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data
    })
}
