<script>
    import { onMount } from 'svelte'
    import { writable } from 'svelte/store';

    // Definicja textToAnimate z pliku Home.svelte
    let textToAnimate = writable('');
    let index = 0;
    let speed = 70; // Adjust the speed of typing animation here

    // Text to animate
    const text = "Jesteśmy by Pamiętać";

    onMount(() => {
        const type = () => {
            if (index < text.length) {
                const currentChar = text.charAt(index);
                if (currentChar === ' ') {
                    textToAnimate.update(oldValue => oldValue + ' '); // Append space without removing it
                } else {
                    textToAnimate.update(oldValue => oldValue + currentChar);
                }
                index++;
                setTimeout(type, speed);
            }
        };
        type();
    });
</script>

<head>
<link rel='stylesheet' href='Home.css'>
</head>
<div id="main-container" class="font-bold h-screen w-full overflow-auto">
    <!--kontener1-->
    <div id="container1" class="h-dvh flex justify-center items-center bg-gradient-to-b from-slate-950 to-slate-800 text-white w-full relative">
        <div id="osiem" class="w-full absolute top-20 left-0 bottom-0 right-0 h-screen text-left flex justify-between items-center">
            <h1 class="text-6xl select-none">{$textToAnimate}</h1>
            <button class="text-4xl">Button</button>
        </div>
    </div>
    
    <!-- Kontener 2 -->
    <div id="container2" class="h-dvh flex justify-center items-center bg-gradient-to-b from-slate-950 to-slate-800 w-full ">
        <div id="osiem" class="w-full  absolute top-20 left-0 bottom-0 right-0 justify-center items-center h-screen flex">
            <p class="text-7xl">Cośtamessa</p>
        </div>
    </div>
    
    <!-- Kontener 3 -->
    <div id="container3" class="h-dvh flex justify-center items-center text-slate-700 bg-gradient-to-b from-slate-950 to-slate-800 w-full ">
        <div id="osiem" class="w-full  absolute top-20 left-0 bottom-0 right-0 justify-center items-center h-screen flex">
            <p class="text-7xl">Home</p>
        </div>
    </div>
</div>

   <style>
#main-container > div {
        
    scroll-padding: 10px; 
}
#main-container {
    
   
    
    -webkit-user-drag:none;
}


*::-webkit-scrollbar {
    width: 0;
    visibility: hidden;
}
*::-webkit-scrollbar-track {
    background: transparent;
    visibility: hidden;
}
*::-webkit-scrollbar-thumb {
    background-color: rgba(30, 41, 59, 0.7);
    border-radius: 10px;
    border: 1px solid transparent;
}


#container1, #container2, #container3 {
    position: relative;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    z-index: 1;
}


/*   #container1 {
    background-image: url('Test tła.gif'); 
    background-size: 105%; 
    background-repeat: no-repeat;
    background-position: center;
    background-color: rgba(0, 0, 0, 0.2); 
}*/
#container2 {
    box-shadow:inset 0px 0px 0px 10px #f00;
    
}
</style>