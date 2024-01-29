<script>
	// --- Imports ---
	
	import Navbar from '../lib/sections/Navbar.svelte';
	import Footer from '../lib/sections/Footer.svelte';
	import { onMount } from "svelte";
	import { mainColorText, mainColorBorder } from '../stores/ColorStore.js';
	const src = "https://media.discordapp.net/attachments/973965163600416768/1200197749409337354/image0.gif?ex=65c54e42&is=65b2d942&hm=c52a162cf4fffd54f42b773c8757c21b1654fcb43b5269d25db4bda2eefd4b19&"
	// --- --- ---

	mainColorText.set("text-white");
	mainColorBorder.set("border-white");

	// --- --- ---

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
				mainColorText.set("text-red-600");
				mainColorBorder.set("border-red-600");
				//--- --- ---
			} else {
				//currentdiv = 3
				mainColorText.set("text-black");
				mainColorBorder.set("border-black");
				//--- --- ---
			}
			// console.log($mainColorText, $mainColorBorder);
		});
		// --- --- ---
	});
</script>

<Navbar />
<div id="main-container" class="font-bold h-screen w-full overflow-auto">
	<div id="container1" class="h-screen flex justify-center items-center text-white w-full">
		<div id="ograniczenie głównej">
		<p class="text-7xl">Home</p>
	</div>
	</div>
	<div id="container2" class="h-screen flex justify-center items-center text-red-600 w-full bg-white">
		<p class="text-7xl">Home</p>
	</div>
	<div id="container3" class="h-screen flex justify-center items-center text-slate-950 w-full bg-red-600">
		<p class="text-7xl">Home</p>
	</div>

	<!-- 1. Po zjechaniu nizej, ma sie znajdowac box z about-us, uwzglednienie:
    - opisu
    - zdjec z podpisem

    2. Trzeba umiescic tu jeszcze box z Najnowszymi postami z Library - jako Nowość -->
</div>
<Footer />

<style>
	/* Making snaping scroll */

	#main-container > div {
	scroll-snap-align: start;
	scroll-padding: 100px; /* Dostosuj wartość do swoich potrzeb */
}
	#main-container {
	scroll-snap-type: y mandatory;
	scroll-snap-stop: always;
	scroll-behavior: smooth;
	overscroll-behavior-y: none;
}
	*::-webkit-scrollbar {
		width: 0; /* naprawilem problem z scrollbarem */
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
	#container1 {
        min-height: 100vh; /* Minimum height of the viewport */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background: black; 
	}


</style>

