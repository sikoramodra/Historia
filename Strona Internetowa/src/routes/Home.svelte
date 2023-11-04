<script>
	import { onMount } from "svelte";

	let container;
    let y;

	onMount(() => {
		container = document.getElementById("container2").offsetTop;

		console.log(container);

		// window.addEventListener("scroll", () => {
		// 	console.log("dziala");
		// });

		// window.addEventListener("scroll", () => {
		// 	// Smoothly scroll to the center position
		// 	console.log(container);
		// 	// Add your scrolling logic here
		// });
	});
</script>

<div id="main-container" class="font-bold h-screen w-full overflow-auto scroll">
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

<svelte:window bind:scrollY={y} />

<style>
	#main-container > div {
		scroll-snap-align: start;
		transition: scroll-snap-align 2s ease;
	}
    

	#main-container {
		scroll-snap-type: y mandatory;
		scroll-behavior: smooth;
		overscroll-behavior-y: none;
	}

	* {
		scrollbar-width: auto;
		scrollbar-color: #8f54a0 #ffffff;
	}

	/* Chrome, Edge, and Safari */
	*::-webkit-scrollbar {
		width: 14px;
	}

	*::-webkit-scrollbar-track {
		background: transparent;
	}

	*::-webkit-scrollbar-thumb {
		background-color: rgba(144, 84, 160, 0.7);
		border-radius: 10px;
		border: 1px solid transparent;
	}
</style>
