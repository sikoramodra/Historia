<script>
	import { onMount } from "svelte";

	export let data;

	let ranks = [];

	// --- Fetching Rank Data ---
	async function fetchRankData() {
		try {
			const response = await fetch(`${import.meta.env.VITE_DB_URL}ranks`);
			ranks = await response.json();
		} catch (error) {
			console.error("Error fetching rank data:", error.message);
		}
	}

	onMount(() => {
		fetchRankData();
	});
</script>

<div class="overflow-auto">
    {#if ranks.length > 0}
        <ul class="divide-y divide-gray-200">
            {#each ranks as rank}
                {#if rank.name !== null}
                    <li class="py-2">
                        <label class="flex items-center text-white">
                            <input name="ranks-radio" id={rank.id} type="radio" class="form-radio h-5 w-5 text-indigo-600 border-gray-300 focus:ring-indigo-500" value={rank.id} bind:group={data} on:change={() => data = rank.id} />
                            <span class="ml-2">{rank.name}</span>
                        </label>
                    </li>
                {/if}
            {/each}
        </ul>
    {:else}
        <p class="text-white">Nie udało się załadować Stopni Wojskowych.</p>
    {/if}
</div>


<style>
	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent; /* Change the background color of the track */
		margin: 1px;
	}

	::-webkit-scrollbar-thumb {
		background-color: rgb(107 114 128); /* Change the color of the scrollbar thumb */
		border-radius: 20px; /* Add rounded corners to the scrollbar thumb */
	}

	::-webkit-scrollbar-thumb:active {
		background-color: rgb(51 65 85); /* Change the color on hover */
	}
</style>
