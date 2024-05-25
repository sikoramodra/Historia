<script>
	// --- Imports ---

	import PeopleInfo from "../lib/layouts/People/PeopleInfo.svelte";
	import { Link } from "svelte-routing";
	import { slide } from "svelte/transition";
	import { mainColorText, mainColorBorder } from "../stores/ColorStore.js";
	import { createSearchStore, searchHandler } from "./../stores/SearchStore.js";
	import { onDestroy, onMount } from "svelte";
	import PeopleCards from "../lib/layouts/People/PeopleCards.svelte";
	import Logo from "../res/Logo pion   tagline_ciemne tło_PNG.png";

	// --- --- ---
	// --- Variables ---

	mainColorText.set("text-white");
	mainColorBorder.set("border-white");

	let chosenPerson;

	// --- Search Related Variables ---

	let dbData = [];

	const searchProducts = dbData.map((product) => ({
		...product,
		searchTerms: `${product.name} ${product.other_names.toString().replace(/,/g, " ")} ${product.code_names.toString().replace(/,/g, " ")} ${
			product.birth_place
		} ${product.birth_date.substring(0, 4)} ${product.death_place} ${product.death_date.substring(0, 4)} ${product.grave} `,
	}));

	const searchStore = createSearchStore(searchProducts);
	const unsubscribe = searchStore.subscribe((model) => {
		searchHandler(model);
	});

	onDestroy(() => {
		unsubscribe();
	});

	// --- --- ---

	// --- Functions ---

	const fetchData = async () => {
		try {
			const response = await fetch(`${import.meta.env.VITE_DB_URL}people`);
			if (!response.ok) {
				throw new Error("Failed to fetch data");
			}
			dbData = await response.json();
			// dbData = dbData.filter((person) => person.status.status === "unverified")
			dbData = dbData.map((product) => ({
				...product,
				searchTerms: `${product.name} ${product.other_names.toString().replace(/,/g, " ")} ${product.code_names
					.toString()
					.replace(/,/g, " ")} ${product.birth_place} ${product.birth_date === null ? "" : product.birth_date.substring(0, 4)} ${
					product.death_place
				} ${product.death_date === null ? "" : product.death_date.substring(0, 4)} ${product.grave} `,
			}));
			console.log(dbData);
			$searchStore.data = dbData;
			$searchStore.filtered = dbData;
		} catch (error) {
			console.error(error);
		}
	};

	let clearInput = () => {
		$searchStore.search = "";
	};

	let handleClearInputKeyPress = (event) => {
		if (event.key == "Enter") {
			event.preventDefault();
			clearInput();
		}
	};

	let personClick = (person) => {
		chosenPerson = person;
	};

	let handleKeyDownPersonCLick = (e, person) => {
		console.log("in handle");
		if (e.key === "Enter") {
			console.log("in enter");
			personClick(person);
		} else if (e.key === "Escape") {
			console.log("in Escape");
			closePopup();
		}
	};

	let closePopup = () => {
		chosenPerson = "";
	};

	// --- --- ---
	// --- Svelte Functions ---

	onMount(fetchData);

	// --- --- ---
</script>

<div class="min-h-screen flex flex-col items-center justify-center text-white bg-gradient-to-b from-slate-950 to-slate-800 relative">
	<!-- Div with Chosen Person Card Info -->
	{#if chosenPerson}
		<div
			on:click|self={closePopup}
			on:keyup={handleKeyDownPersonCLick}
			role="button"
			tabindex="0"
			class="absolute h-[100vh] w-[100vw] flex items-center justify-center bg-black bg-opacity-50 z-20"
		>
			<PeopleInfo data={chosenPerson} {closePopup} />
		</div>
	{/if}

	<!-- Logo / Link to Home page -->
	{#if !$searchStore.search}
		<div transition:slide={{ delay: 0, duration: 400 }} class="h-1/2 user-select-none">
			<Link to="/" class="text-white w-10 mb-8">
				<img src={Logo} alt="Home" class="h-[14em] md:h-[16em] lg:h-[18em]" />
			</Link>
		</div>
	{/if}

	<!-- Search Bar -->
	<div class="text-2xl xl:text-3xl font-semibold flex items-center h-1/2 mt-12 relative z-10">
		<span class="absolute left-4 top-1/2 transform -translate-y-1/2">
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
			bind:value={$searchStore.search}
		/>

		{#if $searchStore.search}
			<span
				class="absolute right-3 top-1/2 transform -translate-y-1/2 cursor-pointer"
				on:click={clearInput}
				on:keydown={handleClearInputKeyPress}
				role="button"
				tabindex="0"
				aria-label="Clear input"
			>
				<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="h-6 w-6 text-slate-700">
					<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
				</svg>
			</span>
		{/if}
	</div>

	<!-- Search Results -->
	{#if $searchStore.search}
		<div
			transition:slide
			class="flex flex-row flex-wrap items-stretch justify-around bg-slate-700 w-[90vw] h-[75vh] rounded-xl m-4 overflow-y-auto p-6 slide-transition"
		>
			{#each $searchStore.filtered as person}
				<div
					on:click={() => personClick(person)}
					on:keyup={(e) => handleKeyDownPersonCLick(e, person)}
					role="button"
					tabindex="0"
					class="bg-red-50 h-min rounded-lg m-1 flex-grow basis-auto border {person.status.status === 'verified' ? 'border-green-600' : 'border-none'}"
				> 	
					<PeopleCards data={person} />
				</div>
			{/each}
		</div>
	{/if}

	<!-- Link to add-person -->
	{#if !$searchStore.search}
		<Link to="/add-person" class="mt-8 user-select-none">
			<div
				transition:slide={{ delay: 0, duration: 400 }}
				class="bg-slate-800 rounded-full user-select-none cursor-pointer shadow-lg hover:scale-105 hover:bg-slate-700 transition-transform duration-300 flex items-center leading-none text-lg p-4"
			>
				<span class="text-white font-semibold mr-2 user-select-none">+</span>
				<span class="text-white font-semibold tracking-wide user-select-none">Dodaj Osobę</span>
			</div>
		</Link>
	{/if}
</div>

<style>
	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent;
		border-radius: 32px;
	}

	::-webkit-scrollbar-thumb {
		box-shadow: inset 0 0 6px rgb(31, 41, 55);
		background-color: rgb(31, 41, 55);
		border-radius: 0.7rem;
	}
</style>
