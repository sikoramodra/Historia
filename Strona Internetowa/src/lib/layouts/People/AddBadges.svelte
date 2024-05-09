<script>
	import { onMount } from "svelte";

	export let data;

	let badges = [];

	// --- Fetching Badge Data ---
	async function fetchBadgeData() {
		try {
			const response = await fetch(`${import.meta.env.VITE_DB_URL}badges`);
			badges = await response.json();
		} catch (error) {
			console.error("Error fetching badge data:", error.message);
		}
	}

	let handleRadio = (sub_badge, badge) => {
		badge.sub_badges.forEach((element) => {
			data = data.filter((item) => item !== element.id);
		});
		data.push(sub_badge.id);
	};

	onMount(() => {
		fetchBadgeData();
	});
</script>

<div>
	{#if badges.length > 0}
		<ul>
			{#each badges as badge, i}
				{#if badge.name !== null && badge.sub_badges.length > 1}
					<label class="text-white border-white border m-2 flex flex-col justify-center text-center rounded-lg shadow-md">
						<p id={badge.id} class="px-4 py-2 text-white font-semibold rounded-md mr-2">
							{badge.name}
						</p>
						<div class="h-px w-full bg-white"></div>
						<ul class="p-4 text-left">
							{#each badge.sub_badges as sub_badge}
								{#if sub_badge.name !== null}
									<label class="block text-white">
										<input
											type="checkbox"
											name={badge.name}
											class="mr-2"
											value={sub_badge.id}
											bind:group={data}
											on:change={() => handleRadio(sub_badge, badge)}
										/>
										{sub_badge.name}
									</label>
								{/if}
							{/each}
						</ul>
					</label>
				{:else}
					<label class="text-white border border-white m-2 rounded-lg shadow-md font-semibold p-4 flex items-center justify-justify">
						<input
							type="checkbox"
							class="form-checkbox h-5 w-5 text-indigo-600 border-gray-300 focus:ring-indigo-500"
							value={badge.sub_badges[0].id}
							bind:group={data}
						/>
						<span class="ml-2 text-center">{badge.name}</span>
					</label>
				{/if}
			{/each}
		</ul>
	{:else}
		<p class="text-white">Nie udało się załadować Odznak.</p>
	{/if}
</div>
