<script>
    
    import { onMount } from "svelte";
    import { writable } from 'svelte/store';
    import Footer from '../lib/sections/Footer.svelte';
    import Navbar from '../lib/sections/Navbar.svelte';
    import { mainColorBorder, mainColorText } from '../stores/ColorStore.js';

    // --- --- ---

    mainColorText.set("text-white");
    mainColorBorder.set("border-white");

    // --- --- ---

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


    onMount(() => {

        const mainContainer = document.getElementById("main-container");

        // --- Function to change colors of Navbar depending on which div it is ---

        mainContainer.addEventListener("scroll", () => {
            const scrollY = mainContainer.scrollTop;
            const container1 = document.getElementById("container1");
            const container2 = document.getElementById("container2");
            const container3 = document.getElementById("container3");

            if (scrollY < container2.offsetTop - 60) {
                //currentdiv = 1
                mainColorText.set("text-white");
                mainColorBorder.set("border-white");
                //--- --- ---
            } else if (scrollY < container3.offsetTop - 60) {
                //currentdiv = 2
                mainColorText.set("text-white");
                mainColorBorder.set("border-white");
                //--- --- ---
            } else {
                //currentdiv = 3
                mainColorText.set("text-white");
                mainColorBorder.set("border-white");
                //--- --- ---
            }
            // console.log($mainColorText, $mainColorBorder);
        });

        // --- 'swipe' up or down with mouse wheel ---
        mainContainer.addEventListener('wheel', (evt) => {
            evt.preventDefault();

            //scroll direction
            let delta = evt.deltaY;

            // Check if target is an element with offsetHeight property
            const target = evt.target;
            if (!(target instanceof HTMLElement && 'offsetHeight' in target)) {
                return;
            }
            //take height of container:
            let contHeight = target.offsetHeight;

            // check direction and apply to contHeight
            if (delta < 0) {
                contHeight = -contHeight;
            }

            mainContainer.scrollTop += contHeight;

        });// --- --- ---
    });
</script>


<Navbar />
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
            <p class="text-7xl">Home</p>
        </div>
    </div>
    
    <!-- Kontener 3 -->
    <div id="container3" class="h-dvh flex justify-center items-center text-slate-700 bg-gradient-to-b from-slate-950 to-slate-800 w-full ">
        <div id="osiem" class="w-full  absolute top-20 left-0 bottom-0 right-0 justify-center items-center h-screen flex">
            <p class="text-7xl">Home</p>
        </div>
    </div>

    <!-- Dodatkowe elementy -->
    <!-- 1. Po zjechaniu niżej, ma się znajdować box z about-us, uwzględnienie: -->
    <!--    - opisu -->
    <!--    - zdjęć z podpisem -->
    <!-- 2. Trzeba umieścić tutaj jeszcze box z Najnowszymi postami z Library - jako Nowość -->
</div>
<Footer />

<style>
    
    #main-container > div {
        scroll-snap-align: center;
        scroll-padding: 10px; 
    }
    #main-container {
        scroll-snap-type: y mandatory;
        scroll-snap-stop: always;
        scroll-behavior: smooth;
        overscroll-behavior-y: contain;
        overscroll-behavior-inline: contain;
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
