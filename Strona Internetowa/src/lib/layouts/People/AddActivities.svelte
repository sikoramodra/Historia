<script>
	import { onMount } from "svelte";

	export let data;
	let activities = [];
	// --- Fetching Activity Data ---

	async function fetchActivityData() {
		try {
			const response = await fetch(`${import.meta.env.VITE_DB_URL}activities/full`);
			activities = await response.json();
			checkIfDataExists();
		} catch (error) {
			console.error("Error fetching activity data:", error.message);
		}
	}

	onMount(() => {
		fetchActivityData();
	});

	let checkIfDataExists = () => {
		data.forEach((element) => {
			activities.forEach((activity) => {
				activity.sub_activities.forEach((sub_activity) => {
					sub_activity.events.forEach((event) => {
						if (element === event.id) {
							sub_activity.fullshow = true;
							activity.fullshow = true;
						}
					});
				});
			});
		});
	};

	// --- --- ---
</script>

<!-- 
<div class="mb-4 relative col-span-2 border border-white p-8 rounded-xl flex flex-col justify-center">
	{#each data as activityData, i (i)}
		<div class="mb-2">
			<p class="block text-white font-bold mb-2">{i === 0 ? "Activity:" : "Other Activities:"}</p>
			<select name="activities" id="activities" bind:value={activityData.id}>
				<option value="" disabled selected>Choose an activity</option>
				{#each activities as activity}
					<option value={activity.id}>{activity.name}</option>
				{/each}
			</select>
			{#if activityData.id}
				{#each activityData.sub_activities as sub_activityData, j (j)}
					<select name="sub_activities" id="sub_activities" bind:value={sub_activityData.id}>
						<option value="" disabled selected>Choose a sub-activity</option>
						{#each activities.find((item) => item.id == activityData.id).sub_activities as sub_activity}
							<option value={sub_activity.id}>{sub_activity.name}</option>
						{/each}
					</select>
					{#if sub_activityData.id}
						<div id="events" class="overflow-y-auto h-40">
							{#each activities
								.find((item) => item.id === activityData.id)
								.sub_activities.find((item) => item.id === sub_activityData.id).events as event}
								{#if event.name !== null}
									<label class="block text-white">
										<input
											type="checkbox"
											class="mr-2"
											value={event.id}
											on:change={(e) => addToData(e, event, i, j)}
											on:click={() => console.log(data)}
										/>
										{event.name}
									</label>
								{/if}
							{/each}
						</div>
					{/if}
				{/each}
			{/if}
		</div>
	{/each}
</div> -->

<div>
	{#if activities.length > 0}
		{#each activities as activity}
			<div class="mb-4 relative col-span-2 border border-white p-8 rounded-xl flex flex-col justify-center">
				<button class="block text-white font-extrabold mb-2 cursor-pointer" on:click={() => (activity.show = !activity.show)}
					>{activity.name}</button
				>
				{#if activity.show || activity.fullshow}
					{#each activity.sub_activities as sub_activity}
						{#if sub_activity.name !== null}
							<div class="border-b border-white mb-2">
								<button
									class="block text-white font-semibold mb-2 cursor-pointer"
									on:click={() => (sub_activity.show = !sub_activity.show)}
								>
									{sub_activity.name}
								</button>
								{#if sub_activity.show || sub_activity.fullshow}
									<div class="overflow-y-auto max-h-40 border border-white rounded-lg p-2 mb-4">
										{#each sub_activity.events as event}
											{#if event.name !== null}
												<label class="block text-white">
													<input
														type="checkbox"
														class="mr-2"
														value={event.id}
														bind:group={data}
														on:change={() => {
															sub_activity.events.forEach((element) => {
																if (data.includes(element.id)) {
																	sub_activity.fullshow = true;
																	activity.fullshow = true;
																}
															});
															if (!data.includes(event.id)) {
																sub_activity.fullshow = false;
																activity.fullshow = false;
															}
														}}
													/>
													{event.name}
												</label>
											{/if}
										{/each}
									</div>
								{/if}
							</div>
						{/if}
					{/each}
				{/if}
			</div>
		{/each}
	{:else}
		<p class="text-white">Nie udało się załadować Wydarzeń.</p>
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
