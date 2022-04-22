

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
    }).then( res => {
        console.info(res);

        return res.json();

    }).then( data => {
        console.info(data);

        let area = document.getElementById("commentArea");

        area.innerHTML = `
            <div class="row">
                <div class="col-md-2" style="padding: 10px">
                    <img style="width: 80px; height: 80px" class="rounded-circle" src="${data.userId.avatar}" onerror="/SaleApplication/images/default.jpg" style="width: 100px"/>
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
        body: JSON.stringify({
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then( res => {
        console.info(res)

        return res.json()

    }).then( data => {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data
    })
}

function updateCart(obj, productId) {
    console.info(obj.value)
    fetch("/SaleApplication/api/cart", {
        method: "put",
        body: JSON.stringify({
            "productId": productId,
            "productName": "",
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then( res => {
        return res.json()
    }).then( data => {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data.counter
        let amount = document.getElementById("amountCart")
        amount.innerText = data.amount
    })
}

function deleteCart(productId) {
    if (confirm("Ban chac chan xoa item nay khong?") == true) {
        fetch(`/SaleApplication/api/cart/${productId}`, {
            method: "delete",
        }).then( res => {
            return res.json()
        }).then( data => {
            let counter = document.getElementById("cartCounter")
            counter.innerText = data.counter
            let amount = document.getElementById("amountCart")
            amount.innerText = data.amount
            let row = document.getElementById(`product${productId}`);
            row.style.display = "none"
        })
    }
}

function pay() {
    if(confirm("Ban cach chan thanh toan?") == true) {
        fetch("/SaleApplication/api/pay", {
            method: "post"
        }).then( res => {
            return res.json();
        }).then( code => {
            console.info(code);
            location.reload();
        })
    }
}
