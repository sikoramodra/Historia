<script>
	// --- Imports ---

	import { onMount } from "svelte";

	// ---
	// --- Colors of navbar ---

	export let mainColorText;
	export let mainColorBorder;

	// ---

	onMount(() => {
		const mainContainer = document.getElementById("main-container");

		// --- Function to change colors of Navbar depending on which div it is ---

		mainContainer.addEventListener("scroll", () => {
			const scrollY = mainContainer.scrollTop;
			const container1 = document.getElementById("container1");
			const container2 = document.getElementById("container2");
			const container3 = document.getElementById("container3");

			if (scrollY < container2.offsetTop - container1.offsetTop) {
				//currentdiv = 1
				mainColorText = "text-white";
				mainColorBorder = "border-white";
				//---
			} else if (scrollY < container3.offsetTop - container1.offsetTop) {
				//currentdiv = 2
				mainColorText = "text-red";
				mainColorBorder = "border-red";
				//---
			} else {
				//currentdiv = 3
				mainColorText = "text-black";
				mainColorBorder = "border-black";
				//---
			}

			//console.log(mainColorBorder, mainColorText);
		});

		// ---
	});
</script>

<div id="main-container" class="font-bold h-screen w-full overflow-auto">
	<div id="container1" class="h-screen flex justify-center items-center text-white w-full">
		<p class="text-7xl">Home</p>
	</div>
	<div id="container2" class="h-screen flex justify-center items-center text-red-700 w-full bg-white">
		<p class="text-7xl">Home</p>
	</div>
	<div id="container3" class="h-screen flex justify-center items-center text-slate-950 w-full bg-red-700">
		<p class="text-7xl">Home</p>
	</div>

	<!-- 1. Po zjechaniu nizej, ma sie znajdowac box z about-us, uwzglednienie:
    - opisu
    - zdjec z podpisem

    2. Trzeba umiescic tu jeszcze box z Najnowszymi postami z Library - jako Nowość -->
</div>

<style>
	/* Making snaping scroll */

	#main-container > div {
		scroll-snap-align: start;
	}
	#main-container {
		scroll-snap-type: y mandatory;
		scroll-behavior: smooth;
		overscroll-behavior-y: none;
	}
	*::-webkit-scrollbar {
		width: 14px;
	}
	*::-webkit-scrollbar-track {
		background: transparent;
	}
	*::-webkit-scrollbar-thumb {
		background-color: rgba(30, 41, 59, 0.7);
		border-radius: 10px;
		border: 1px solid transparent;
	}

	/* ---   ---   --- */
</style>
