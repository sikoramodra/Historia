<script>
	import { Link } from "svelte-routing";
	import { mainColorText, mainColorBorder } from "../store.js";

	mainColorText.set("text-white");
	mainColorBorder.set("border-white");

	let inputValue = "";

	let handleInput = (event) => {
		inputValue = event.target.value;
	};

	let clearInput = () => {
		inputValue = "";
	};

	let handleClearInputKeyPress = (event) => {
		if (event.key == "Enter") {
			event.preventDefault();
			clearInput();
		}
	};
</script>

<div class="min-h-screen flex flex-col items-center justify-center text-white bg-gradient-to-b from-slate-950 to-slate-800 relative">
	<div class="h-1/2 user-select-none">
		<Link to="/" class="text-white w-10 mb-8">
			<img
				src="https://raw.githubusercontent.com/sikoramodra/Historia/stronka/Strona%20Internetowa/src/res/Logo%20pion%20%20%20tagline_ciemne%20tło_PNG.png"
				alt="Home"
				class="h-[14em] md:h-[16em] lg:h-[18em]"
			/>
		</Link>
	</div>
	<form action="" method="" class="text-2xl xl:text-4xl font-semibold flex items-center h-1/2 mt-12 relative">
		<span class="absolute left-4 top-1/2 transform -translate-y-1/2">
			<!-- Add your search icon here -->
			<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="h-6 w-6 text-slate-700">
				<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M11 2a9 9 0 0 1 9 9c0 5-4 9-9 9a9 9 0 0 1-9-9c0-5 4-9 9-9z"
				></path>
				<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6"></path>
			</svg>
		</span>

		<input
			type="text"
			placeholder="Szukaj..."
			class="p-3 pl-12 pr-10 bg-slate-800 text-white border-2 border-slate-700 rounded-full transition-all duration-300 leading-none"
			bind:value={inputValue}
			on:input={handleInput}
		/>

		{#if inputValue !== ""}
			<span
				class="absolute right-3 top-1/2 transform -translate-y-1/2 cursor-pointer"
				on:click={clearInput}
				on:keydown={handleClearInputKeyPress}
				role="button"
				tabindex="0"
				aria-label="Clear input"
			>
				<!-- Add your close (x) icon here -->
				<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="h-6 w-6 text-slate-700">
					<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
				</svg>
			</span>
		{/if}
	</form>

	<Link to="/add-person" class="absolute bottom-4 right-4 user-select-none">
		<div class="bg-slate-800 rounded-full user-select-none cursor-pointer shadow-lg hover:scale-105 hover:bg-slate-700 transition-transform duration-300 flex items-center leading-none text-lg p-4">
			<span class="text-white font-semibold mr-2 user-select-none">+</span>
			<span class="text-white font-semibold tracking-wide user-select-none">Add Person</span>
		</div>
	</Link>
</div>
