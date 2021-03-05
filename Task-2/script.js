let post = document.getElementById('posts');

let submit = document.getElementById('btn');
let title = document.getElementById('title');
let body = document.getElementById('body');
let userId = document.getElementById('userId');


async function posts() {
    await fetch('https://jsonplaceholder.typicode.com/posts')
        .then((response) => response.json())
        .then((json) => json.forEach(i => {
            let div = document.createElement('div')
            div.classList.add('card');
            div.setAttribute('data-id', i.id)
            for (const property in i) {
                if (property !== 'id') {
                    let divwrap = document.createElement('div');
                    let span = document.createElement('span');
                    let data = document.createElement('data');
                    divwrap.classList.add(`${property}`);
                    span.innerText = `${property}: `;
                    let str = i[property].toString();
                    str = str.replace(/(\r\n|\n|\r)/gm, "");
                    data.innerText = `${str}`
                    divwrap.appendChild(span);
                    divwrap.appendChild(data);
                    div.appendChild(divwrap);
                }
            }
            let btndiv = document.createElement('div');
            btndiv.classList.add('button');
            let del = document.createElement('button');
            del.id = 'delete';
            del.innerText = 'Delete';
            let com = document.createElement('button');
            com.id = 'comment';
            com.innerText = 'Comments';
            btndiv.appendChild(del);
            btndiv.appendChild(com);
            div.appendChild(btndiv)
            post.appendChild(div);
            console.log(div)
        }))

    console.log('ji')
    cardevent()
}


submit.addEventListener('click', async (e) => {

    e.preventDefault();

    await fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        body: JSON.stringify({
            title: title.value,
            body: body.value,
            userId: userId.value,
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then((response) => response.json())
        .then((i) => {
            let div = document.createElement('div')
            div.classList.add('card');
            div.setAttribute('data-id', i.id)
            for (const property in i) {
                if (property !== 'id') {
                    let divwrap = document.createElement('div');
                    let span = document.createElement('span');
                    let data = document.createElement('data');
                    divwrap.classList.add(`${property}`);
                    span.innerText = `${property}: `;
                    let str = i[property].toString();
                    str = str.replace(/(\r\n|\n|\r)/gm, "");
                    data.innerText = `${str}`;
                    divwrap.appendChild(span);
                    divwrap.appendChild(data);
                    div.appendChild(divwrap)
                }
            }
            let btndiv = document.createElement('div');
            btndiv.classList.add('button');
            let del = document.createElement('button');
            del.id = 'delete';
            del.innerText = 'Delete';
            let com = document.createElement('button');
            com.id = 'comment';
            com.innerText = 'Comments';
            btndiv.appendChild(del);
            btndiv.appendChild(com);
            div.appendChild(btndiv)
            post.appendChild(div);
            div.scrollIntoView();
        })
    title.value = ''
    body.value = ''
    userId.value = ''
    cardevent()
})




function cardevent() {

    let card = document.querySelectorAll('button');
    card.forEach(i => {

        i.addEventListener('click', e => {

            if (e.target.id == 'comment') {
                // console.log(e.target.id)
                // console.log(e.target.parentNode.parentNode);
                // fetch(`https://jsonplaceholder.typicode.com/posts/${e.target.parentNode.parentNode.getAttribute("data-id")}/comments`)
                //     .then((response) => response.json())
                //     .then((json) => {
                //         //
                //         //
                //     });
                const tab = window.open(`https://jsonplaceholder.typicode.com/posts/${e.target.parentNode.parentNode.getAttribute("data-id")}/comments`, '_blank');
            }
            else {
                fetch(`https://jsonplaceholder.typicode.com/posts/${e.target.parentNode.parentNode.getAttribute("data-id")}`, {
                    method: 'DELETE',
                });
                e.target.parentNode.parentNode.remove();
            }
            // console.log(e.target.parentNode.parentNode.getAttribute("data-id"));
        })
    })
}