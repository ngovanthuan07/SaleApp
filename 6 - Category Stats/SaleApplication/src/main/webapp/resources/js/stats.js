function generateColor() {
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`
}

function cateChart(id, cateLabels=[], cateInfo=[]) {
    let colors = []
    for (let i = 0; i < cateInfo.length; i++)
        colors.push(generateColor())

    const data = {
        labels: cateLabels,
        datasets: [{
            label: 'Thong ke san pham theo danh muc',
            data: cateInfo,
            backgroundColor: colors,
            hoverOffset: 4
        }]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config)
}