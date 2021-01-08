import axios from "axios";

const posts = {
    21111: [{
        id: 1,
        author: 'Kate',
        text: 'Hello everyone!'
    },
        {
            id: 2,
            author: 'Sasha',
            text: 'Hello, Katya!'
        }],
    100500: [{
        id: 1,
        author: 'Anya',
        text: 'I don\'t like frontend T_T'
    }]
}

export function getPosts(id, cb) {
    // fake an API request
    if (posts[id]) {
        posts[id].forEach(data => {
            let post = {author: data.author, text: data.text}
            cb(null, post)
        })
    } else {
        try {
            axios
                .get(`http://localhost:8080/api/GetPosts?user_id=${id}`)
                .then(response => {
                    response.data.forEach(data => {
                        let post = {author: data.author_name, text: data.message}
                        cb(null, post)
                    })
                })
        } catch (err) {
            console.error(err)
        }
    }
}