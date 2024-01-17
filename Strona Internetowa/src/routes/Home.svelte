<script>
	// --- Imports ---
	
	import Navbar from './../lib/Navbar.svelte';
	import Footer from '../lib/Footer.svelte';
	import { onMount } from "svelte";
	import { mainColorText, mainColorBorder } from '../stores/ColorStore.js';

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
		<p class="text-7xl">Home</p>
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

	/* ---   ---   --- */
</style>

