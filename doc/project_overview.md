Project Overview: codeq.me
==============================


Background
-----------

**Why was this project proposed?**

codeq.me is an attempt to sharpen my skills in Clojure's web-facing stack, using tools like Datomic, ClojureScript, Om and Pedestal-service.

**What business need/challenge are we solving?**

The desire to sharpen skills like:

* Systems design
* General Development in Clojure
* UI/UX
* DevOps

The system itself is codeq-as-a-service. 

**What are the pain points today?**

*On skills*: A general lack of familiarity with the tools, both incumbents and newcomers. Time away from frontend development has left previous skills there dull.

*On codeq*: The Codeq tool can be difficult to setup, requiring active installions of both codeq and Datomic, along with enough knowledge of Datomic and Codeq's schema to query it for any useful insights.

**What auxiliary goals/opportunities are we trying to accomplish or achieve?**

* Add another project to my portfoilio
* Provide value to those in the community
* Fodder for blog post

**How long is the solution expected to last?**

This project should freshen me up for the next 3-6 months, paving the way for larger, more complicated systems.

The tool itself should have a low enough to be run indefinitely.


**What constraints currently exist for the project?**

Primarily time.


Project statement
------------------

```
The (name of team) will
(build, develop, design, implement, etc.)
a (what) for (whom)
```

**The `Ryan` will design and implement a hosted version of Codeq with a number of built-in widgets for gaining insight about a codebase**


### Completion

This project will be be considered **successfully** completed when there is a hosted Codeq service that can import and analyze Clojure repositories from GitHub, with two widgets: one that exposes the tree of *symbols* in the project, and another that exposes the history of a *symbol* across *commits*.


### Win conditions

Everyone gets to pick three

| Condition             |   1   |   2   |   3   | Definition                   |
| :-------------------- | :---: | :---: | :---: | :--------------------------- |
| Schedule              |       |       |       |                              |
| Scope                 |       |       |    3  | Less is more–because this is a full-stack project, time and effort should be spread evenly across the project. |
| Quality               |       |    2  |       | Since this project is focussed on improving skills, effort should be made to *do it right*. |
| Budget                |       |       |       |                              |
| Customer satisfaction |       |       |       |                              |
| Teamwork/Learning     |   1   |       |       | At its core, this project is about learning the tools. Even failure to complete the project could still be considered a partial success. |

 1. Learning
 2. Quality
 3. Scope


### Scope

| In Scope                       | Out of Scope                             |
| :----------------------------: | :--------------------------------------: |
| UI/UX Design                   | Additional Widgets beyond core two       |
| Testing                        | Support for private repositories         |
| Application Hosting            |                                          |
| Deployment                     |                                          |
| GitHub auth				      |                                          |
|                                |                                          |
|                                |                                          |
|                                |                                          |
|                                |                                          |


### Quality attributes and scenarios

Everyone gets to pick three
Definitions from [MSDN Architecture Guide](http://msdn.microsoft.com/en-us/library/ee658094.aspx)

| Attribute       |   1   |   2   |   3   | Definition                              |
| :-------------- | :---: | :---: | :---: | :-------------------------------------- |
| Scalability     |       |       |       | The ability of a system to handle increases in load without impact on the performance/runtime characteristics of the system |
| Security        |       |       |       | The capability of a system to prevent malicious or accidental actions outside of the designed usage, and to prevent disclosure or loss of information |
| Modifiability   |       |       |       | The ability of the system to undergo changes with a degree of ease |
| Maintainability |       |       |       | The ease of which the system is monitored, serviced, deployed, updated; Manageability |
| Reliability     |       |       |       | The ability of a system to remain operational over time, in the face of errors/defects/unknowns |
| Availability    |       |       |       | The proportion of time that the system is functional and working |
| Robustness      |       |       |       | The extent to which a software system can tolerate changes in its environment without intervention |
| Adaptability    |       |       |       | The extent to which a software system adapts to change in its environment without intervention |
| Usability       |       |       |       | Conformance to requirements, fitting [good design criteria](https://en.wikipedia.org/wiki/Heuristic_evaluation#Nielsen.27s_heuristics) |
| Performance     |       |       |       | Do you mean latency? throughput? etc? |

#### Quality attribute ranking

_ > _ > _

#### Scenarios // thresholds

 * TODO


### Known risks and areas of unknown risks

 * TODO


Metrics
-------

Metrics help us understand the project's context and progress.  They aid in
recognizing and identifying when project-wide problems occur.  Metrics provide
a baseline of objective data for making informed project-oriented decisions.

### Project metrics

 * Iteration burn up - points dev-completed within an iteration
 * Project burn down - total points remaining for the project (delivered to production)
 * Running tested features - cards or points delivered to production (not including defects or tasks)

### Software metrics


### System metrics


Extra
-----

### Special Conditions

 * Open source?
 * IP Restrictions?
 * Special documents?
 * Special clearance?
 * Additional technology restrictions?


### Baseline top-down estimations

 * Use [COCOMO with Monte Carlo simulation](http://csse.usc.edu/tools/COCOMO.php) to get an idea of where the project might end up


### Baseline bottom-up estimations

Break down all major milestones into their individual tasks, and estimate effort (person-months) based on historical data


Schedule
--------
*Caveat: if the per-phase assumptions are false, phases will need to be adjusted/adapted*

### Phase 1

 * TODO

