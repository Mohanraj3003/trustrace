let inputs = document.querySelectorAll('input')

let submit = document.getElementById('submit'); 
let patterns ={
    fname:/^[a-z]+$/i,
    lname:/^[a-z]+$/i,
    email:/^([a-z\d\.\+]+)@([a-z\d-]+)\.([a-z]{2,6})$/,
    number1:/\d/,
    number2:/\d/,
    number3:/\d/
}

// validation function
function validate(field, regex){

    if(regex.test(field.value)){
        field.className = 'valid';
    } else {
        field.className = 'invalid';
    }

}

inputs.forEach((input) => {
    input.addEventListener('keyup', (e) => {
        // console.log(e.target);
            validate(e.target, patterns[e.target.attributes.name.value]);
    });
});


// let hi = new Promise((resolve,reject)=>{
//         // resolve('sucess..!')

//         reject('fail..!');
//     })


// hi.then((result)=>{
//     console.log(result)
// }).catch(e=>{
//     console.log(e)
// })  
